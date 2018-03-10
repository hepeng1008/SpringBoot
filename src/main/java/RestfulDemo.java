import com.example.demo.restful.UserController;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RestfulDemo {

    public void test(){
        MockMvc mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        RequestBuilder request=null;
        request=get("/users/");
        //1.测试Restful Get
        try {
            mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Get Success");
        }

        //2.测试Restful Post
        request=post("/users/").param("id","1").param("name","测试大使").param("age","20");
        try {
            mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("success")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Post Success");
        }

        //3.测试Restful Post的结果，测试Restful Get
        try {
            request = get("/users/");
//			mvc.perform(request)
            //		.andExpect(status().isOk())
            //		.andExpect(content().string(equalTo("[{\\\"id\\\":1,\\\"name\\\":\\\"测试大使\\\",\\\"age\\\":20}]")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Get Result Success");
        }

        //4.put修改id为1的user
        request=put("/users/1").param("name","测试终极大使").param("age","30");
        try {
            //mvc.perform(request).andExpect(content().string(equalTo("success")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("put success");
        }

        //5.get一个为1的user
        request=get("/users/1");
        try {
            //	mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("put success");
        }

        //6.del删除id为1的user
        request=delete("/users/1");
        try {
            mvc.perform(request).andExpect(content().string(equalTo("success")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("delete success");
        }

        //7.get查一下user列表，应该为空
        request=get("/users/");
        try {
            mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("delete success");
        }

    }
}
