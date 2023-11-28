/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalamus.persistenciaBaseDatos;

import com.mycompany.kalamus.Planeta.ExcepPlanetas.ExcepcionPlaneta;
import com.mycompany.kalamus.Planeta.Planeta;
import com.mycompany.kalamus.especie.Esser;
import com.mycompany.kalamus.especie.subEspecies.Andorians;
import com.mycompany.kalamus.especie.subEspecies.Ferengi;
import com.mycompany.kalamus.especie.subEspecies.Humans;
import com.mycompany.kalamus.especie.subEspecies.Klingon;
import com.mycompany.kalamus.especie.subEspecies.Nibirians;
import com.mycompany.kalamus.especie.subEspecies.Vulcanians;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class dao {

    private Connection conexio;

    public ArrayList<Planeta> selectAllPlaneta(HashMap<String, Planeta> listaPlanetas) throws SQLException, ExcepcionPlaneta {

        String query = "select * from planeta;";
        ArrayList<Planeta> ListaPlanetas = new ArrayList<>();
        Statement st = conexio.createStatement();

        //Executem la consulta i recollim el resultat
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String nom = rs.getString("nom");
            String galaxia = rs.getString("galaxia");
            int capacitat = rs.getInt("capacitat");
            String clima = rs.getString("clima");
            Boolean floravermella = rs.getBoolean("floravermella");
            Boolean essersaquatics = rs.getBoolean("essersaquatics");
            ListaPlanetas.add(new Planeta(nom, galaxia, capacitat, clima, floravermella, essersaquatics));
        }
        rs.close();
        st.close();
        return ListaPlanetas;

    }

    public void insertPlaneta(HashMap<String, Planeta> listaPlanetas) throws SQLException {
        String insert = "INSERT INTO planeta (nom, galaxia, capacitat, clima, floravermella, essersaquatics) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conexio.prepareStatement(insert);

        for (Planeta p : listaPlanetas.values()) {
            ps.setString(1, p.getNom());
            ps.setString(2, p.getGalaxia());
            ps.setInt(3, p.getCapacitat());
            ps.setString(4, String.valueOf(p.getTipoClima()));
            ps.setBoolean(5, p.getFloraVermella());
            ps.setBoolean(6, p.getEssersAquatics());
            ps.executeUpdate();
        }

        ps.close();
    }

    public void insertEsser(Esser e) throws SQLException {
        try {
            String insert = "INSERT INTO esser (nom, nivellcivilitzacio) VALUES (?, ?);";
            PreparedStatement ps = conexio.prepareStatement(insert);

            ps.setString(1, e.getNom());
            ps.setInt(2, e.getNivellCivilitzacio());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException exEsser) {
            System.out.println("Error: Esser no ha sido insertado a la tabla Essers");
        }
    }

    public void insertSubEsser(Esser esser) throws SQLException {
        if (esser instanceof Humans) {
            try {

                String insertHuma = "INSERT INTO huma ( nom, edat, genere) VALUES (?, ?, ? );";
                PreparedStatement ps = conexio.prepareStatement(insertHuma);

                ps.setString(1, esser.getNom());
                ps.setInt(2, ((Humans) esser).getEdat());
                ps.setBoolean(3, ((Humans) esser).getGenere());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInHuma) {
                System.out.println("Error: Huma no ha sido insertado a la tabla Vulcania");
            }
        } else if (esser instanceof Vulcanians) {
            try {

                String insertVulcania = "INSERT INTO vulcania (nom) VALUES (?);";
                PreparedStatement ps = conexio.prepareStatement(insertVulcania);
                ps.setString(1, esser.getNom());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInVulcania) {
                System.out.println("Error: Vulcania no ha sido insertado a la tabla Vulcania");
            }
        } else if (esser instanceof Andorians) {
            try {

                String insertAndoria = "INSERT INTO andoria (nom, rol) VALUES (?,?);";
                PreparedStatement ps = conexio.prepareStatement(insertAndoria);
                ps.setString(1, esser.getNom());
                String rol = String.valueOf(((Andorians) esser).getTipoRol());
                ps.setString(2, rol);

                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInAndoria) {
                System.out.println("Error: Andoria no ha sido insertado a la tabla Andoria");
            }
        } else if (esser instanceof Nibirians) {
            try {

                String insertNibiria = "INSERT INTO nibiria (nom) VALUES (?);";
                PreparedStatement ps = conexio.prepareStatement(insertNibiria);
                ps.setString(1, esser.getNom());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInNibirians) {
                System.out.println("Error: Nibiria no ha sido insertado a la tabla Nibiria");
            }
        } else if (esser instanceof Klingon) {
            try {

                String insertKlingon = "INSERT INTO klingon (nom ,forca) VALUES (?,?);";
                PreparedStatement ps = conexio.prepareStatement(insertKlingon);
                ps.setString(1, esser.getNom());
                ps.setInt(2, ((Klingon) esser).getForca());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInKlingon) {
                System.out.println("Error: Klingon no ha sido insertado a la tabla Klingon");
            }
        }else if (esser instanceof Ferengi) {
            try {

                String insertFerengi = "INSERT INTO ferengi (nom ,oro) VALUES (?,?);";
                PreparedStatement ps = conexio.prepareStatement(insertFerengi);
                ps.setString(1, esser.getNom());
                ps.setInt(2, ((Ferengi) esser).getOr());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException exInFerengi) {
                System.out.println("Error: Ferengi no ha sido insertado a la tabla Ferengi");
            }
        }
    }

    private boolean existePlaneta(Planeta p) {
        return false;
    }

    public void conectar() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/kalamus";
        String user = "postgres";
        String pass = "";
        conexio = DriverManager.getConnection(url, user, pass);
    }

    public void desconectar() throws SQLException {
        if (conexio != null) {
            conexio.close();
        }
    }

}
