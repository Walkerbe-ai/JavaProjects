package com.example.bilet3;

import java.util.ArrayList;
import java.util.List;

public class Passanger {

        public int idPassanger;
        public String surname;
        public String name;
        public String otchestvo;
        public ArrayList<String> idReis;

        public Passanger (int idPassanger, String surname, String name, String otchestvo, ArrayList<String> idReis)
        {
            this.idPassanger = idPassanger;
            this.surname = surname;
            this.name = name;
            this.otchestvo = otchestvo;
            this.idReis = idReis;}

        public int getIdPassanger() {
            return idPassanger;
        }

        public void setIdPassanger(int idPassanger) {
            this.idPassanger = idPassanger;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOtchestvo() {
            return otchestvo;
        }

        public void setOtchestvo(String otchestvo) {
            this.otchestvo = otchestvo;
        }

        public ArrayList<String> getIdReis() {
            return idReis;
        }

        public void setIdReis(ArrayList<String> idReis) {
            this.idReis = idReis;
        }

}
