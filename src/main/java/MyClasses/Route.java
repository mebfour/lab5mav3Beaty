package MyClasses;

import java.time.ZonedDateTime;
import java.util.Date;


public class Route {
    private static int idGenerator;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле не может быть null
    private Location to; //Поле может быть null
    private Double distance; //Поле может быть null, Значение поля должно быть больше 1
    private String key;

    public Route(int id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, Location from, Location to, Double distance) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.key = key;
    }

    public Route(String name, Coordinates coordinates, Location from, Location to, Double distance) {
        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public Route() {}

    public void setKey(String key) {
        this.key = key;
    }
    public String getKey(){
        return key;
    }


    public static class RouteBuilder {
        private static long idGenerator = 1; //в качестве id будем генерить числа последовательно
        private long id;
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private Location from; //Поле не может быть null
        private Location to; //Поле может быть null
        private Double distance;
        private String key;

        public RouteBuilder(String name, Coordinates coordinates, Location from, Location to, Double distance) {
            this.name = name;
            this.coordinates = coordinates;
            this.from = from;
            this.to = to;
            this.distance = distance;
        }



        public void setName(String name) {
            this.name = name;
        }

        public void setCoordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
        }

        public void setFrom(Location from) {
            this.from = from;
        }

        public void setTo(Location to) {
            this.to = to;
        }

        public void setDistance(Double distance) {
            this.distance = distance;
        }
        public void setKey (String key){
            this.key = key;
        }

        public Route build(){ return  new Route();}
    }

    public static void setIdGenerator(int idGenerator){
        Route.idGenerator = idGenerator;
    }

    {
        this.id = idGenerator++;
        this.creationDate = java.time.ZonedDateTime.now();
    }


    public int compareTo(Route route){
        return Long.compare(route.getId(), id);
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String toString() {
        String info = "";
        info += "\n Ключ: " + key;
        info += "\n Имя: " + name;
        info += "\n Координаты: " + coordinates;
        String date = creationDate.toString();
        info += '\n'+"Добавлен "+date.substring(0, 10)+" "+date.substring(11, 19)+'\n';
        info += "\n Куда " + to;
        info += "\n Откуда " + from;
        info += "\n Расстояние "+ distance;
        info += "\n id: " + id+ '\n' + "=========================================";;
        return info;
    }



}
