package com.idm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.idm.entity.Utente;
import com.idm.service.UtenteService;

@Controller
//@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

  


    @GetMapping("/register")
    public String register() {
        return "register";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<CustomResponse> getUtenteById(@PathVariable long id){
//        return CustomResponse.success(HttpStatus.OK.toString(), utenteService.getUtenteById(id), HttpStatus.OK);
//    }
//
//    @GetMapping("prenotazioni/{id}")
//    public ResponseEntity<CustomResponse> getPrenotazioniUtente(@PathVariable long id){
//        return CustomResponse.success((HttpStatus.OK.toString()), utenteService.prenotazioniUser(id), HttpStatus.OK);
//    }
//
//    @GetMapping("abbonamenti/{id}")
//    public ResponseEntity<CustomResponse> getAbbonamnetiUtente(@PathVariable long id){
//        return CustomResponse.success((HttpStatus.OK.toString()), utenteService.abbonamentiUser(id), HttpStatus.OK);
//    }

//    @PutMapping("/edit/{id}")
//    public ResponseEntity<CustomResponse> updateUtente(@PathVariable int id, @RequestBody @Validated UtenteRequestUpdate utenteRequestUpdate, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
//        return CustomResponse.success(HttpStatus.OK.toString(), utenteService.update(id, utenteRequestUpdate), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<CustomResponse> deleteUtente(@PathVariable long id){
//      utenteService.delete(id);
//        return CustomResponse.emptyResponse("L'utente con id = " + id + " è stato cancellato", HttpStatus.OK);
//
//    }
//
//    @PatchMapping("/upload/{id}")
//    public ResponseEntity<CustomResponse> uploadAfotoProfilo(@PathVariable int id,@RequestParam("upload") MultipartFile file) throws IOException {
//            Utente utente = utenteService.uploadFotoProfilo(id, (String)
//            cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
//            return CustomResponse.success(HttpStatus.OK.toString(), utente, HttpStatus.OK);
//    }
//
//
//    @PatchMapping("/{username}")
//    public Utente changeRole(@PathVariable String username, @RequestBody String role){
//
//        return utenteService.updateRole(username, role);
//
//    }
//    @PatchMapping("/edit/password/{id}")
//    public ResponseEntity<CustomResponse> uploadPassword(@PathVariable long id, @RequestBody @Validated PasswordRequest passwordRequest, BindingResult bindingResult){
//
//        if (bindingResult.hasErrors())
//            throw new BadRequestException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
//
//        Utente utente = utenteService.getUtenteById(id);
//
//        if (!encoder.matches(passwordRequest.getOldPassword(), utente.getPassword())) throw  new RuntimeException("Password sbagliata");
//        if (encoder.matches(passwordRequest.getNewPassword(), utente.getPassword())) throw  new RuntimeException("Password vecchia uguale a quella nuova");
//
//        return CustomResponse.success(HttpStatus.OK.toString(),utenteService.updatePassword(id, passwordRequest.getNewPassword()), HttpStatus.OK);
//    }
}
