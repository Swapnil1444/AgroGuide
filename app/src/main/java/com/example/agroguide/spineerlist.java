package com.example.agroguide;

public class spineerlist {
        private String name;
        private String location;
        private String date;
        private String price;

        public spineerlist(String name, String location, String date, String price) {
            this.name = name;
            this.location = location;
            this.date = date;
            this.price = price;
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getDate() {
            return date;
        }

        public String getPrice() {
            return price;
        }
    }



