package com.searchcode.app.dao.searchcode;


import com.searchcode.app.config.IDatabaseConfig;
import com.searchcode.app.config.MySQLDatabaseConfig;
import com.searchcode.app.config.Values;
import com.searchcode.app.dto.searchcode.Code;
import com.searchcode.app.service.Singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeDAO {

    private IDatabaseConfig dbConfig;

    public CodeDAO() {
        this.dbConfig = new MySQLDatabaseConfig();
    }

    public synchronized List<Code> getAllCode() {
        List<Code> codeList = new ArrayList<>();

        try {
            Connection conn = this.dbConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT id, location, uncompress(content) as content FROM code;");

            ResultSet rs = stmt.executeQuery();

            int id = 0;
            String location = Values.EMPTYSTRING;
            String content = Values.EMPTYSTRING;
            while (rs.next()) {
                id = rs.getInt("id");
                location = rs.getString("location");
                content = rs.getString("content");

                codeList.add(new Code(id, location, content));
            }



            stmt.close();
            conn.close();
        }
        catch(SQLException ex) {
            Singleton.getLogger().severe(" caught a " + ex.getClass() + "\n with message: " + ex.getMessage());
        }

        return codeList;
    }

}
