package com.api.unipar.controller;

import com.api.unipar.entidades.Categoria;
import com.api.unipar.services.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public List<Categoria> listarTodasCategorias(){
        return categoriaService.listarTodasCategoria();
    }

    @PostMapping("/salvar-categoria")
    public Categoria salvarCategoria(@RequestBody Categoria categoria){
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping("/buscar-categoria/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Long id){
        return categoriaService.buscarCategoriaPorId(id);
    }

    @DeleteMapping("/deletar-categoria/{id}")
    public void deletarCategoriaPorId(@PathVariable Long id){
        categoriaService.deletarCategoriaPorId(id);
    }

    @PutMapping("/atualizar-categoria")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizarCategoria(categoria, id);
    }
}
