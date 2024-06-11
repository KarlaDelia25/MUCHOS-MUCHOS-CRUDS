package Papeleria;

public class NegocioPapeleria {
String id;
String nom;
String pre;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPre() {
	return pre;
}
public void setPre(String pre) {
	this.pre = pre;
}
public String getCan() {
	return can;
}
public void setCan(String can) {
	this.can = can;
}
public String getTotal() {
	return total;
}
public void setTotal(String total) {
	this.total = total;
}
String can;
String total;

DataPapeleria de=null;
public NegocioPapeleria() {
	de= new DataPapeleria();
}
public boolean insertar() {
	if(de.insertar(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean cargar() {
	if(de.cargar(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean actualizar() {
	if(de.actualizar(this)) {
		return true;
	}else {
		return false;
	}
}
public boolean eliminar() {
	if(de.eliminar(this.id)) {
		return true;
	}else {
		return false;
	}
}







}
