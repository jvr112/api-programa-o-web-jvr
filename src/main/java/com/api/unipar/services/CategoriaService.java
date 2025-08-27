package com.api.unipar.services;

import com.api.unipar.entidades.Categoria;
import com.api.unipar.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodasCategoria() {
        return categoriaRepository.findAll();
    }

    public Categoria salvarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deletarCategoriaPorId(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarCategoriaPorId(Long id){
        return categoriaRepository.
                findById(id).orElseThrow(() -> new RuntimeException("A categoria com id" + id + "não existe"));
    }

    public Categoria atualizarCategoria(Categoria categoria, Long id){
        Categoria categoriaSalvo = buscarCategoriaPorId(id);
        BeanUtils.copyProperties(categoria, categoriaSalvo, "id");
        return categoriaRepository.save(categoriaSalvo);
    }
}
