package com.example.alberth.appstopinfraction.data.model;

/**
 * Created by Lab02-06 on 21/12/2017.
 */

public class Papeleta {

    private Integer idPapeleta = 0;
    private String fname_conductor="" ;
    private String lname_conductor ="";
    private String name_infraction="" ;
    private String matricula="" ;
    private String type_vehicle="" ;
    private Double monto = 0.0;
    private String date ="";
    private String place ="";
    private String gps="" ;
    private String color_vehicle="";

    public String getColor_vehicle(){
        return color_vehicle;
    }
    public void setColor_vehicle(String color_vehicle){
        this.color_vehicle =  color_vehicle;
    }

    public Papeleta(String fname, String lname, String name_infraction,  String matricula ,
                    String type_vehicle,  String color_vehicle, Double monto,  String date , String place){
        super();
        this.fname_conductor = fname;
        this.lname_conductor = lname;
        this.name_infraction = name_infraction;
        this.matricula = matricula;
        this.type_vehicle = type_vehicle;
        this.color_vehicle = color_vehicle;
        this.monto = monto;
        this.date = date;
        this.place = place;
    }

    public Papeleta(int idPapeleta, String fname, String lname, String name_infraction,  String matricula ,
                    String type_vehicle, String color_vehicle, Double monto,  String date , String place){
        super();
        this.idPapeleta = idPapeleta;
        this.fname_conductor = fname;
        this.lname_conductor = lname;
        this.name_infraction = name_infraction;
        this.matricula = matricula;
        this.type_vehicle = type_vehicle;
        this.color_vehicle = color_vehicle;
        this.monto = monto;
        this.date = date;
        this.place = place;
    }

    public Papeleta(String fname, String lname){
        super();
        this.fname_conductor = fname;
        this.lname_conductor = lname;
    }

    public Papeleta(Integer idPapeleta, String fname, String lname, String matricula, String date
    ){
        super();
        this.idPapeleta = idPapeleta;
        this.fname_conductor = fname;
        this.matricula = matricula;
        this.date = date;
        this.lname_conductor = lname;
    }


    public Papeleta(){
        super();
    }


    public Integer getIdPapeleta() {
        return idPapeleta;
    }

    public void setIdPapeleta(Integer idPapeleta) {
        this.idPapeleta = idPapeleta;
    }

    public String getFname_conductor() {
        return fname_conductor;
    }

    public void setFname_conductor(String fname_conductor) {
        this.fname_conductor = fname_conductor;
    }

    public String getLname_conductor() {
        return lname_conductor;
    }

    public void setLname_conductor(String lname_conductor) {
        this.lname_conductor = lname_conductor;
    }

    public String getName_infraction() {
        return name_infraction;
    }

    public void setName_infraction(String name_infraction) {
        this.name_infraction = name_infraction;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getType_vehicle() {
        return type_vehicle;
    }

    public void setType_vehicle(String type_vehicle) {
        this.type_vehicle = type_vehicle;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
}
