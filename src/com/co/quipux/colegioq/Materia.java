
package com.co.quipux.colegioq;

import java.util.Objects;


public class Materia {
    
    private Long id = null;
    
    private String nombre;
    
    private long idprofesor; 

    public Materia(String nombre, long idprofesor) {
        this.nombre = nombre;
        this.idprofesor = idprofesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(long idprofesor) {
        this.idprofesor = idprofesor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + (int) (this.idprofesor ^ (this.idprofesor >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (this.idprofesor != other.idprofesor) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + ", idprofesor=" + idprofesor + '}';
    }
    
    
}
