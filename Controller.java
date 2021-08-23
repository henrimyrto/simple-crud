/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinjava;

/**
 *
 * @author Henri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Controller {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONNSTRING = "jdbc:mysql://localhost:3306/puna";

    Controller() {

    }

    private Connection getConnection() {

        Connection conn;
        try {
            conn = DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
            //System.out.println("Connected");
            return conn;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    private Connection get() {
        return getConnection();
    }

    public void shihDepartamentet() {

        ArrayList<Departament> lista = new ArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM departament";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Departament d = null;
            while (rs.next()) {
                d = new Departament(rs.getInt("idDepartamentit"), rs.getString("lloji"),
                        rs.getString("administratori"), rs.getInt("nrPunonjesve"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(lista.toString());

    }

    public void shtoDepartament(int id, String ll, String ad) {

        Connection conn = getConnection();
        try {
            String query = " INSERT INTO departament "
                    + "(idDepartamentit,lloji,administratori)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setInt(1, id);
            preparedSt.setString(2, ll);
            preparedSt.setString(3, ad);
            preparedSt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateDepartament(int id, String ad) {

        Connection conn = getConnection();
        try {
            String query = "UPDATE departament "
                    + "SET administratori=?"
                    + "WHERE idDepartamentit = ?";
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setString(1, ad);
            preparedSt.setInt(2, id);
            preparedSt.execute();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDepartament(int id) {

        String query = "DELETE FROM departament WHERE idDepartamentit= ? ";
        Connection conn = getConnection();
        try {
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setInt(1, id);
            preparedSt.execute();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void shihPunonjesit() {

        ArrayList<Punonjes> lista = new ArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM punonjes";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Punonjes p = null;
            while (rs.next()) {
                p = new Punonjes(rs.getInt("id"), rs.getInt("idDepartamentit"), rs.getString("emri"),
                        rs.getString("mbiemri"), rs.getInt("mosha"), rs.getDouble("paga"),
                        rs.getString("llojiPunonjesit"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(lista.toString());

    }

    public void shtoPunonjes(int id, int idDep, String e, String mb, int mo, double p, String ll) {

        Connection conn = getConnection();
        try {

            String query = " INSERT INTO punonjes "
                    + "(id,idDepartamentit,emri,mbiemri,mosha,paga,llojiPunonjesit)"
                    + " values (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setInt(1, id);
            preparedSt.setInt(2, idDep);
            preparedSt.setString(3, e);
            preparedSt.setString(4, mb);
            preparedSt.setInt(5, mo);
            preparedSt.setDouble(6, p);
            preparedSt.setString(7, ll);
            preparedSt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                shtoNrEPunonjesve(idDep);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void shtoNrEPunonjesve(int id) {

        Connection conn = getConnection();
        int nr = -1;
        try {
            String query1 = "SELECT nrPunonjesve FROM departament WHERE idDepartamentit = ?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setInt(1, id);
            st.execute();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nr = rs.getInt("nrPunonjesve");
            }
            nr++;
            ndrysho(nr, id);
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void ndrysho(int nr, int id) {

        Connection conn = getConnection();
        try {
            String query = "UPDATE departament SET nrPunonjesve = ? WHERE idDepartamentit = ?";
            PreparedStatement preparedStt = conn.prepareStatement(query);
            preparedStt.setInt(1, nr);
            preparedStt.setInt(2, id);
            preparedStt.execute();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePunonjes(int id, int idDep, String e, String mb, int mo, double p, String ll) {

        Connection conn = getConnection();
        try {

            shtoHiqPunonjes(id, idDep);

            String query = "UPDATE punonjes "
                    + "SET idDepartamentit = ?, emri=?,mbiemri= ?,mosha=?,paga= ?,llojiPunonjesit=?"
                    + "WHERE id = ?";
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setInt(1, idDep);
            preparedSt.setString(2, e);
            preparedSt.setString(3, mb);
            preparedSt.setInt(4, mo);
            preparedSt.setDouble(5, p);
            preparedSt.setString(6, ll);
            preparedSt.setInt(7, id);
            preparedSt.execute();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void shtoHiqPunonjes(int id, int idDep) {

        Connection conn = getConnection();
        int oldID=-1;
        try {
            String query1 = "SELECT idDepartamentit FROM punonjes WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setInt(1, id);
            st.execute();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                oldID = rs.getInt("idDepartamentit");
            }
            if (oldID != idDep) {
                shtoNrEPunonjesve(idDep);
                hiqNrEPunonjesve(oldID);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePunonjes(int id, int idDep) {

        String query = "DELETE FROM Punonjes WHERE id= ? ";
        Connection conn = getConnection();
        try {
            PreparedStatement preparedSt = conn.prepareStatement(query);
            preparedSt.setInt(1, id);
            preparedSt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                hiqNrEPunonjesve(idDep);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void hiqNrEPunonjesve(int id) {

        Connection conn = getConnection();
        int nr = -1;
        try {
            String query1 = "SELECT nrPunonjesve FROM departament WHERE idDepartamentit = ?";
            PreparedStatement st = conn.prepareStatement(query1);
            st.setInt(1, id);
            st.execute();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                nr = rs.getInt("nrPunonjesve");
            }
            nr--;
            ndrysho(nr, id);
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
