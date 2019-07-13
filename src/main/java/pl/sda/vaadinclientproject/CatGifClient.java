package pl.sda.vaadinclientproject;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatGifClient {

//    public String getCatPictureFromApi() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<CatPicture> exchange;
//        String s = "";
//        for (; ; ) {
//            exchange = restTemplate.exchange("https://aws.random.cat/meow",
//                    HttpMethod.GET, HttpEntity.EMPTY, CatPicture.class);
//
//            s = exchange.getBody().getFile();
//            if (s.endsWith(".gif")) {
//                break;
//            }
//        }
//        return s;
//    }

        private RestTemplate restTemplate;

        public CatGifClient(){
            this.restTemplate = new RestTemplate();
        }

        public String getCatGifFromApi() {
            String url;
            while(true) {
                ResponseEntity<String> exchange = restTemplate.exchange("https://aws.random.cat/meow",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        String.class);
                String json = exchange.getBody();
                JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
                url = jsonObject.get("file").getAsString();
                if (url.endsWith(".gif")){
                    break;
                }
            }
            return url;
        }
    }

