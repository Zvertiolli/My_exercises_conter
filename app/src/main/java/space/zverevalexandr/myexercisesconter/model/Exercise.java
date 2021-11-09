package space.zverevalexandr.myexercisesconter.model;

public class Exercise {
    int id;
    String title;
    int count;
    int plan;
    int ready;

    public Exercise(int id, String title, int count, int plan) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.plan = plan;
        this.ready = ready;
    }

    public int getReady() {
        return ready;
    }

    public void setReady(int ready) {
        this.ready = ready;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
