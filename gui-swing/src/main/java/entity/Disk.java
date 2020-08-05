package entity;

/**
 * @Program: knowledge-base
 * @Description: Disk
 * @Author: BitterGourd
 * @Date: 2020-05-26 14:42
 */
public class Disk {
    private int id;
    private String name;
    private String message;
    private int num;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", num=" + num +
                '}';
    }
}
