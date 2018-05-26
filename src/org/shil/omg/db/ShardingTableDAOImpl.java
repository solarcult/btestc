package org.shil.omg.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.shil.omg.db.connect.SeedDBDataBaseManager;

public class ShardingTableDAOImpl {

	public static final String CREATE_SEED_TABLE_PREFIX = "CREATE TABLE seed_";
	public static final String CREATE_SEED_TABLE_POSTFIX = "(\n" +
            "    `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "    `seed` VARCHAR(250) NOT NULL,\n" +
            "    `status` INT NOT NULL DEFAULT 0,\n" +
            "    `balance` BIGINT(20) NOT NULL DEFAULT 0,\n" +
            "    PRIMARY KEY (`id`),\n" +
            "    UNIQUE INDEX `seed_UNIQUE` (`seed` ASC)\n" +
            ")\n";
	
	public static String INSERT_SEED_PREFIX_SQL = "INSERT INTO seed_";
	public static String INSERT_SEED_POSTFIX_SQL = " (seed,status,balance) VALUES (? , ? , ?)";
	
	public static String createTableSql(int tableIndex) {
		return CREATE_SEED_TABLE_PREFIX+tableIndex+CREATE_SEED_TABLE_POSTFIX;
	}
	
	public static void createWholeShardingTable() {
		for(int i=0;i<ShardingUtil.ShardingTotal;i++) {
			try {
				SeedDBDataBaseManager.getConnection().createStatement().executeUpdate(createTableSql(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertSeedTested(String seed) {
		PreparedStatement s = null;
		try {
			String insertSql = INSERT_SEED_PREFIX_SQL+ShardingUtil.getTableIndex(seed)+INSERT_SEED_POSTFIX_SQL;
			s = SeedDBDataBaseManager.getConnection().prepareStatement(insertSql);
			s.setString(1, seed);
			s.setInt(2, 0);
			s.setLong(3, 0);
			s.executeUpdate();
			s.close();
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("createSeedError:"+seed, e);
		}finally {
			try {
				if(s!=null) s.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void updateSeedTested2Done(int tableIndex,long id) {
		String updateSql = "UPDATE seed_"+tableIndex+" SET status = 1 WHERE id = ?";
		
		PreparedStatement d = null;
		try {
            d = SeedDBDataBaseManager.getConnection().prepareStatement(updateSql);
            d.setLong(1, id);
            d.executeUpdate();
            d.close();
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("updateSeedTableIndex"+tableIndex +" id:" + id, e);
		}finally {
			try {
				if(d!=null) d.close();
			} catch (Exception ex) {
//				e.printStackTrace();
			}
		}
	}
	
	public static void updateSeedsTested2Done(int tableIndex,List<Long> ids) {
		if(ids.isEmpty()) return;
		
		StringBuilder inids = new StringBuilder();
		for(long id : ids) {
			inids.append(id);
			inids.append(",");
		}
		
		String updateSql = "UPDATE seed_"+tableIndex+" SET status = 1 WHERE id in ( "+inids.substring(0,inids.length()-1)+" )";
		
		Statement s = null;
		try {
			s = SeedDBDataBaseManager.getConnection().createStatement();
			s.executeUpdate(updateSql);
			s.close();
		}catch(Exception e) {
			DuplicateTableDAOImpl.errorRecord("updateSeedsTested2Done "+tableIndex +" inids:" + inids.toString(), e);
		}finally {
			try {
				if(s!=null) s.close();
			} catch (Exception ex) {
//				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		try {
//			MysqlDataBaseManager.getConnection().createStatement().executeUpdate(createTableSql(8888));
//			insertSeedTested("I am a fucking good seed");
//			updateSeedTested(2787, 188);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
