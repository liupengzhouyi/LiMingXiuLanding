package LinkDatabase.LinkMySQL;


import LinkDatabase.LinkMySQL.LinkTool.LinkMySQL8_0_16;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    private LinkMySQL8_0_16 linkMySQL8_0_16;

    private String sql;

    private boolean results;

    private int resultSet;

    public DeleteData(LinkMySQL8_0_16 linkMySQL8_0_16, String sql) throws SQLException {
        this.linkMySQL8_0_16 = linkMySQL8_0_16;
        //要执行的SQL语句
        this.setSql(sql);
        //2.创建statement类对象，用来执行SQL语句！！
        Statement statement = this.linkMySQL8_0_16.getConnection().createStatement();
        //3.查看删除结果
        int resultSet = statement.executeUpdate(sql);
        this.setResultSet(resultSet);
    }

    public DeleteData(String sql) throws SQLException, ClassNotFoundException {
        this.linkMySQL8_0_16 = new LinkMySQL8_0_16();
        //要执行的SQL语句
        this.setSql(sql);
        //2.创建statement类对象，用来执行SQL语句！！
        Statement statement = this.linkMySQL8_0_16.getConnection().createStatement();
        //3.查看删除结果
        int resultSet = statement.executeUpdate(sql);
        this.setResultSet(resultSet);
    }

    public LinkMySQL8_0_16 getLinkMySQL8_0_16() {
        return linkMySQL8_0_16;
    }

    public void setLinkMySQL8_0_16(LinkMySQL8_0_16 linkMySQL8_0_16) {
        this.linkMySQL8_0_16 = linkMySQL8_0_16;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean isResults() {
        return results;
    }

    public void setResults(boolean results) {
        this.results = results;
    }

    public int getResultSet() {
        return resultSet;
    }

    public void setResultSet(int resultSet) {
        this.resultSet = resultSet;
    }
}
