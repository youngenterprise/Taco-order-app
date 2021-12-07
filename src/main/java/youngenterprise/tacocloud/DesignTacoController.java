package youngenterprise.tacocloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import youngenterprise.tacocloud.Taco;
import youngenterprise.tacocloud.Ingredient.Type;
import youngenterprise.tacocloud.data.IngredientRepository;
import youngenterprise.tacocloud.data.TacoRepository;

import javax.validation.Valid;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo){
        this.ingredientRepo=ingredientRepo;
        this.designRepo=designRepo;
    }

    @ModelAttribute(name="order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name="taco")
    public Taco taco(){
        return new Taco();
    }

    {/*@ModelAttribute
    public String addIngredientsToModel(Model model){
        List<Ingredient> ingredients= Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types=Ingredient.Type.values();
        for(Type type:types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
        }
        model.addAttribute("design",new Taco());
        return "design";
    } */}


    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients= new ArrayList<>();
        ingredientRepo.findAll().forEach(i->ingredients.add(i));

        Type[] types=Ingredient.Type.values();
        for(Type type:types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }
        Taco saved = designRepo.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }

    private List<Ingredient>filterByType(List<Ingredient>ingredients,Type type){
        return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
    }
}
