package com.example.libertfarma.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = true, length = 100)
    private String receta;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name ="farmacia.id")
    private Farmacia farmacia;
}
