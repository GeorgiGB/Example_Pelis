import java.sql.*;

public class Main {

    private static Conexio laConexio;

    public static void main(String[] args) throws SQLException {
        laConexio = new Conexio();
        cargaryMostrarpeli();
        leerYGuardarPeli();
    }

    public static void cargaryMostrarpeli() throws SQLException {

        try {
            Connection con = laConexio.getConexio();

            String sql = "Select * from Pelis where idPelis=8";

            Statement st = con.createStatement();

            ResultSet rst = st.executeQuery(sql);

            Pelicula p = null;
            if (rst.next()) {
                p = new Pelicula(
                        rst.getInt("idPelis"),
                        rst.getString("Titol"),
                        rst.getInt("Any"),
                        rst.getString("Director")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void leerYGuardarPeli() throws SQLException{
        Pelicula p = new Pelicula(
                Leer.leerEntero("Dime codigo: "),
                Leer.leerTexto("Dime el titulo: "),
                Leer.leerEntero("Dime el año: "),
                Leer.leerTexto("Dime el director: ")
        );

        Connection con = laConexio.getConexio();

        String sql = "INSERT into Pelis(Any,Titol,Director) values (?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, p.getAny());
        pst.setString(2, p.getTitol());
        pst.setString(3, p.getDirector());

        int res = pst.executeUpdate();
    }
}
