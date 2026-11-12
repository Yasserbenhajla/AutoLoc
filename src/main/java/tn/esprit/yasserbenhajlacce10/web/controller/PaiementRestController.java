package tn.esprit.yasserbenhajlacce10.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasserbenhajlacce10.domain.Paiement;
import tn.esprit.yasserbenhajlacce10.service.impls.IPaiementServices;

import java.util.List;

@Tag(name = "Paiements", description = "Gestion des paiements")
@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementRestController {

    private final IPaiementServices paiementServices;

    @Operation(summary = "Lister les paiements")
    @ApiResponse(responseCode = "200", description = "Liste des paiements")
    @GetMapping
    public List<Paiement> findAll() {
        return paiementServices.findAll();
    }

    @Operation(summary = "Consulter un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @GetMapping("/{id}")
    public Paiement findById(@Parameter(description = "Identifiant du paiement") @PathVariable Long id) {
        return paiementServices.findById(id);
    }

    @Operation(summary = "Créer un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Paiement créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement create(@RequestBody Paiement paiement) {
        return paiementServices.create(paiement);
    }

    @Operation(summary = "Modifier un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @PutMapping("/{id}")
    public Paiement update(@Parameter(description = "Identifiant du paiement") @PathVariable Long id,
                           @RequestBody Paiement paiement) {
        paiementServices.findById(id);
        paiement.setIdPaiement(id);
        return paiementServices.update(paiement);
    }

    @Operation(summary = "Supprimer un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Paiement supprimé"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant du paiement") @PathVariable Long id) {
        paiementServices.findById(id);
        paiementServices.deleteById(id);
    }
}