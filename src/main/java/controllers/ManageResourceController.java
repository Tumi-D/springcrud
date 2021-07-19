package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import models.City;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

// import models.Country;
// import repositories.CountryRepository;
// import repositories.CityRepository;

@RestController
@RequestMapping(path = "/api") // This means URL's start with /api (after Application path)
public class ManageResourceController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public String addNewResource(@RequestParam String name, @RequestParam String population) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String sql = "INSERT INTO cities(name,population) VALUES (?,?);";
        int result = jdbcTemplate.update(sql, name, population);
        if (result > 0) {
            return "Saved";
        }
        return "Not Saved";
    }

    @PutMapping(path = "/update") // Map ONLY POST Requests
    public String updateResource(@RequestParam String name, @RequestParam String population, @RequestParam Integer id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String sql = "UPDATE cities SET name = ?, population= ? WHERE id = ?;";
        int result = jdbcTemplate.update(sql, name, population, id);
        if (result > 0) {
            return "Updated";
        }
        return "Not Updated";
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<City> findAll() {
        String sql = "SELECT * FROM cities;";
        List<City> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<City>(City.class));
        if (!customers.isEmpty()) {
            return customers;
        }
        return null;
    }

    @GetMapping(path = "/find")
    public @ResponseBody List<City> findSingle(@RequestParam Integer id) {
        String sql = "SELECT * FROM cities WHERE id= " + String.format("%d", id) + ";";
        List<City> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<City>(City.class));
        if (!customers.isEmpty()) {
            return customers;
        }
        return null;
    }

    @DeleteMapping(path = "/delete") // Map ONLY POST Requests
    public String deleteResource(@RequestParam Integer id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        String sql = "DELETE FROM cities WHERE id= ?;";
        int result = jdbcTemplate.update(sql, id);
        if (result > 0) {
            return "Deleted";
        }
        return "Not Deleted";
    }

}
