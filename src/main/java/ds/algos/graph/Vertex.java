package ds.algos.graph;

import java.util.Objects;

public class Vertex {
    String label;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return label != null ? label.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
