package tn.esprit.yasserbenhajlacce10.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasserbenhajlacce10.domain.Vehicule;
import tn.esprit.yasserbenhajlacce10.service.IVehiculeServices;

import java.util.List;

@Tag(name = "Véhicules", description = "Gestion du parc de véhicules")
@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeServices vehiculeServices;

    @Operation(summary = "Lister les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules")
    @GetMapping
    public List<Vehicule> findAll() {
        return vehiculeServices.findAll();
    }

    @Operation(summary = "Consulter un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @GetMapping("/{id}")
    public Vehicule findById(@Parameter(description = "Identifiant du véhicule") @PathVariable Long id) {
        return vehiculeServices.findById(id);
    }

    @Operation(summary = "Créer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeServices.create(vehicule);
    }

    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @PutMapping("/{id}")
    public Vehicule update(@Parameter(description = "Identifiant du véhicule") @PathVariable Long id,
                           @RequestBody Vehicule vehicule) {
        vehiculeServices.findById(id);
        vehicule.setIdVehicule(id);
        return vehiculeServices.update(vehicule);
    }

    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant du véhicule") @PathVariable Long id) {
        vehiculeServices.findById(id);
        vehiculeServices.deleteById(id);
    }

    @PutMapping("/{idVehicule}/agence/{idAgence}")
    public Vehicule assignAgence(@PathVariable long idVehicule,
                                 @PathVariable long idAgence) {
        return vehiculeServices.assignAgence(idVehicule, idAgence);
    }

    @PutMapping("/{idVehicule}/equipement/{idEquipement}")
    public Vehicule assignEquipement(@PathVariable long idVehicule,
                                     @PathVariable long idEquipement) {
        return vehiculeServices.assignEquipement(idVehicule, idEquipement);
    }

    @DeleteMapping("/{idVehicule}/equipement/{idEquipement}")
    public Vehicule unassignEquipement(@PathVariable long idVehicule,
                                       @PathVariable long idEquipement) {
        return vehiculeServices.unassignEquipement(idVehicule, idEquipement);
    }

    @Operation(summary = "Ajouter un véhicule avec ses équipements et l'affecter à une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule et équipements créés, agence affectée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
    })
    @PostMapping("/agence/{agenceId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule addAndAssignAgence(@RequestBody Vehicule vehicule,
                                       @Parameter(description = "Identifiant de l'agence") @PathVariable Long agenceId) {
        return vehiculeServices.addAndAssignAgence(vehicule, agenceId);
    }
}