
package com.co.quipux.colegioq.dao.mysql;

import com.co.quipux.colegioq.Alumno;
import com.co.quipux.colegioq.dao.AlumnoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MYSQLAlumnoDAO implements AlumnoDAO {
    
    final String INSERT = "INSERT INTO alumnos(id_alumno, nombre, apellido, fecha_nac) VALUES(?, ?, ?, ?) ";
      final String UPDATE = "UPTADE alumnos SET nombre = ?, apellidos = ?, fecha_nac = ? WHERE id_alumno = ?"; 
      final String DELETE = "DELETE FROM alumnos WHERE id_alumno = ?,";
        final String GETALL = "SELECT id_alumno, nombre, apellidos,fecha_nac FROM alumnos ";
        final String GETONE = "SELECT id_alumno, nombre, apellidos,fecha_nac FROM alumnos WHERE id_alumno = ?";
        
   private Connection Conn;
    private final Connection conn;
   public MYSQLAlumnoDAO(Connection conn) {
        this.conn= conn;
    }


    @Override
    public void insertar(Alumno a) {
        PreparedStatemend stat = null;
        try{ 
            stat = (PreparedStatemend) conn.prepareStatement(INSERT);
             stat.setLong(1, a.getId());
           stat.setString(2, a.getNombre());
           stat.setString(3, a.getApellidos());
     stat.setDate(4,new Date(a.getFechanacimiento().getTime())); 
             } catch (SQLException ex) {
            Logger.getLogger(MYSQLAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
         
        }
    }
    
    private Alumno convertir(ResulSet rs ) {
     
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        Date fechaNac = rs.getDate ("fecha_nac");
        Alumno alumno = new Alumno(nombre, apellidos, fechaNac);
        alumno.setId(rs.getLong("id_alumno"));
        return alumno;
    }

    @Override
    public void modificar(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Alumno a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> obtenerTodos() {
           PreparedStatement stat = null;
        ResultSet rs = null;
        List<Alumno> alumnos = null;
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            if (rs.next()){
                Alumno a = convertir();
            } else {
                throw DAOException("No se a encontrado ese registro.");
            }
        } catch (SQLException ex) {
            try {
                throw new DAOException("Error en SQL", ex);
            } catch (com.co.quipux.colegioq.dao.mysql.DAOException ex1) {
                
            }
        } catch (Exception ex) {
            Logger.getLogger(MYSQLAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        if (rs != null){
            try {
                stat.close();
            } catch (SQLException ex) {
                new DAOException("Error en SQL,", ex);
            }
        }
    }
        List<Alumno> a = null;
        return a;
    }

    @Override
    public Alumno obtener(Long id)  {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Alumno a = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                a = convertir();
            } else {
                throw DAOException("No se a encontrado ese registro.");
            }
        } catch (SQLException ex) {
            try {
                throw new DAOException("Error en SQL", ex);
            } catch (com.co.quipux.colegioq.dao.mysql.DAOException ex1) {
                
            }
        } catch (Exception ex) {
            Logger.getLogger(MYSQLAlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        if (rs != null){
            try {
                stat.close();
            } catch (SQLException ex) {
                new DAOException("Error en SQL,", ex);
            }
        }
    }
        return a;
    
    }

    private Alumno convertir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Exception DAOException(String no_se_a_encontrado_ese_registro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class ResulSet {

        public ResulSet() {
        }

        private String getString(String nombre) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Date getDate(String fecha_nac) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private Long getLong(String id_alumno) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
