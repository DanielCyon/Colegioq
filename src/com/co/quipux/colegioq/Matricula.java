
package com.co.quipux.colegioq;

import java.util.Objects;


public class Matricula {
    
    private long alumno;
    
    private long materia;
    
    private int year;
    
    private Integer nota = null;

    public Matricula(long alumno, long materia, int year) {
        this.alumno = alumno;
        this.materia = materia;
        this.year = year;
    }

    public long getAlumno() {
        return alumno;
    }

    public void setAlumno(long alumno) {
        this.alumno = alumno;
    }

    public long getMateria() {
        return materia;
    }

    public void setMateria(long materia) {
        this.materia = materia;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.alumno ^ (this.alumno >>> 32));
        hash = 97 * hash + (int) (this.materia ^ (this.materia >>> 32));
        hash = 97 * hash + this.year;
        hash = 97 * hash + Objects.hashCode(this.nota);
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
        final Matricula other = (Matricula) obj;
        if (this.alumno != other.alumno) {
            return false;
        }
        if (this.materia != other.materia) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula{" + "alumno=" + alumno + ", materia=" + materia + ", year=" + year + ", nota=" + nota + '}';
    }
    
}
