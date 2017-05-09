package Util;

import java.sql.*;

import Entity.Guitar;
import Service.GuitarService;

public class addGuitar {
	private GuitarService guitarService;
	
	  public GuitarService getGuitarService() {
		return guitarService;
	}

	public void setGuitarService(GuitarService guitarService) {
		this.guitarService = guitarService;
	}

	public static void main( String args[] )
	  {		  
        // TODO Auto-generated method stub
        try {
            // 0 ����SQLite��JDBC
            String sql="jdbc:sqlite:db/work.db";
            Class.forName("org.sqlite.JDBC");

            // 1 ����һ�����ݿ���zieckey.db�����ӣ���������ھ��ڵ�ǰĿ¼�´���֮
            Connection conn = DriverManager.getConnection(sql);
            Statement stat = conn.createStatement();
            
            // 2 ����һ����tbl1��¼������
//            stat.executeUpdate("insert into Guitar values(1,'����1','1��','aģ��',100.00,'ǰ��1','a����')"); 

            ResultSet rs = stat.executeQuery("select * from Guitar;"); // ��ѯ����
            while (rs.next()) {  
                System.out.println(rs.getString("backWood") + rs.getDouble("price"));  
            }  
            rs.close();

            conn.close(); // �������ݿ������
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	  }

