package com.uptc.frw.casoestudioredis.services;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import com.uptc.frw.casoestudioredis.jpa.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;  // Repositorio para interactuar con la base de datos de fabricantes

    /**
     * Guarda una lista de fabricantes en la base de datos.
     * @param manufacturers lista de fabricantes a guardar
     * @return lista de fabricantes guardados
     */
    public List<Manufacturer> saveAllManufacturers(List<Manufacturer> manufacturers) {
        return manufacturerRepository.saveAll(manufacturers);  // Guarda todos los fabricantes a la vez
    }

    /**
     * Obtiene todos los fabricantes almacenados en la base de datos.
     * @return lista de todos los fabricantes
     */
    public List<Manufacturer> findAllManufacturer(){
        return manufacturerRepository.findAll();  // Devuelve todos los fabricantes usando el repositorio
    }

    /**
     * Busca un fabricante por su ID.
     * @param id ID del fabricante
     * @return el fabricante encontrado o null si no existe
     */
    public Manufacturer findManufacturerById(Long id){
        System.out.println("Encontrando fabricante de la DB con ID : " + id);
        return manufacturerRepository.findById(id).orElse(null);  // Busca el fabricante por su ID
    }

    /**
     * Guarda un nuevo fabricante en la base de datos.
     * @param manufacturer el fabricante a guardar
     * @return el fabricante guardado
     */
    public Manufacturer saveManufacturer(Manufacturer manufacturer){
        System.out.println("Guardando fabricante" + manufacturer.getNameManufacturer());
        return manufacturerRepository.save(manufacturer);  // Guarda el fabricante
    }

    /**
     * Actualiza un fabricante existente en la base de datos.
     * @param manufacturer el fabricante con los nuevos datos
     * @return el fabricante actualizado
     */
    public Manufacturer updateManufactuer(Manufacturer manufacturer){
        // Busca el fabricante a actualizar por su ID
        Manufacturer manufacturerUpdate = findManufacturerById(manufacturer.getIdManufacturer());

        // Actualiza los datos del fabricante
        manufacturerUpdate.setNameManufacturer(manufacturer.getNameManufacturer());
        manufacturerUpdate.setAddressManufacturer(manufacturer.getAddressManufacturer());
        manufacturerUpdate.setPhoneManufacturer(manufacturer.getPhoneManufacturer());
        manufacturerUpdate.setRifManufacturer(manufacturer.getRifManufacturer());
        manufacturerUpdate.setFiscalDomicileManufacturer(manufacturer.getFiscalDomicileManufacturer());

        System.out.println("Actualizando fabricante" + manufacturerUpdate.getNameManufacturer());

        // Guarda el fabricante actualizado
        return manufacturerRepository.save(manufacturerUpdate);
    }

    /**
     * Elimina un fabricante por su ID.
     * @param idManufacturer el ID del fabricante a eliminar
     */
    public void deleteManufacturer(long idManufacturer){
        System.out.println("Se ha eliminado el fabricante con ID " + idManufacturer);
        manufacturerRepository.deleteById(idManufacturer);  // Elimina el fabricante por su ID
    }
}
