/*.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootTest
public class ProductoControllerTest {

    @Test
    public List<Producto> testListar() {
        List<Producto> lista = ProductoController.Listar();

        List<Producto> listaEsperado = new ArrayList<Producto>();
        assertEquals(listaEsperado, lista, 0.01);
    }    
}*/