package spotwheater.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spotwheater.exception.NotFoundException;
import spotwheater.model.SpotWheater;
import spotwheater.service.SpotWheaterService;
import spotwheater.util.SpotWheaterView;

@RestController
public class SpotWheaterController extends BaseController {

    @Autowired
    private SpotWheaterService spotwheaterservice;



    /**
     * @api {get}/spotwheater/:city
     * @apiGroup SpotWheater
     * @apiVersion 1.0.0
     *
     * @apiHeader {String} nomeDeUsuario Nome do usuário que está realizando a requisição.
     * @apiHeader {String} token         Token de acesso.
     *
     * @apiHeaderExample {String} Exemplo de cabeçalho:  
     *     "nomeDeUsuario": admin
     *     "token":         PXO9PmSpQwukqfjqg5ukbG3O1Hgl1yH0
     *
     * @apiParam {Number} id Identificador do banco.
     *
     * @apiSuccess {String} City        Named City identifier.
     * @apiSuccess {Number} tempereture Temperature of selecioned city.
     * @apiSuccess {String}
     * @apiSuccess {String}
     *
     * @apiSuccessExample success answer
     *     HTTP/1.1 200 OK
     *     {
     *       "City": Sao Carlos, BR,
     *       "temperature": 7,
     *       "",
     *       ""
     *     } 
     *
     * @apiError Unauthorized Usuário não autorizado a acessar o recurso solicitado.
     *
     * @apiErrorExample Unauthorized
     *     HTTP/1.1 401 Unauthorized          
     *
     * @apiError NotFound city ​​not found.
     *
     * @apiErrorExample NotFound
     *     HTTP/1.1 404 Not Found
     *     {
     *       "timestamp": "09/06/2018 10:02:47",
     *       "status": 404,
     *       "reason": "Not Found",
     *       "exception": "aplicacaofinanceira.exception.NotFoundException",
     *       "message": "city ​​not found",
     *       "path": "/spotwheater/0"
     *     }      
     */
    @RequestMapping(
            value = "/spotwheater",
            params = {"city","country"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(SpotWheaterView.SpotWheaterSimple.class)
    public ResponseEntity<SpotWheater> findOne(@RequestParam("city") String city, @RequestParam("country") String country) throws NotFoundException {
        SpotWheater spotWheater = spotwheaterservice.findOne(city,country);

        return new ResponseEntity<>(spotWheater, HttpStatus.OK);
    }

}
