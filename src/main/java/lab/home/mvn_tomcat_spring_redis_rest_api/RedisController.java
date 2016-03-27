/*
 * Copyright (C) 2016 Dimitrios Dimas <dimitrios.work@outlook.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package lab.home.mvn_tomcat_spring_redis_rest_api;

import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dimitrios Dimas <dimitrios.work@outlook.com>
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    private final Logger log = LoggerFactory.getLogger(RedisController.class);
    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(value = "/sayhai", method = RequestMethod.GET)
    public String sayHai() {
        log.info("request hit redis/sayhai");
        return "hi!";
    }

    @RequestMapping(value = "/diag", method = RequestMethod.GET)
    public String diag() {
        log.info("request hit redis/diag");

        Value ddao = ctx.getBean(Value.class);
        return "Diags, ctx = " + ctx.toString() + " , ctx.getBean(Value.class)="
                + ctx.getBean(Value.class).toString() + " , actual ddao = "
                + ddao.toString() + "<end";
    }

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    public KeyValuePair heartbeatJSON(@RequestParam(value = "key", defaultValue = "heartbeat") String key) {
        log.info("request hit redis/heartbeat, the key we'll use is: " + key);
        Value ddao = ctx.getBean(Value.class);
        return new KeyValuePair(key, (String) ddao.get(key));
    }

    @RequestMapping(value = "/getkeys", method = RequestMethod.GET)
    public String getKeys() {
        log.info("request hit redis/getkeys");
        Value ddao = ctx.getBean(Value.class);
        Iterator iter = ddao.getAll();
        
        return "when i grow up i'll be returning all keys";
    }

    @RequestMapping(value = "/getvalue", method = RequestMethod.GET)
    public KeyValuePair keyValueJSON(@RequestParam(value = "key") String key) {
        log.info("request hit redis/getvalue, the supplied key was: " + key);
        Value ddao = ctx.getBean(Value.class);
        return new KeyValuePair(key, (String) ddao.get(key));
    }

    @RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
    public KeyValuePair keyValueJSONUrl(@PathVariable String key) {
        log.info("request hit redis/get/, the supplied key was: " + key);
        Value ddao = ctx.getBean(Value.class);
        return new KeyValuePair(key, (String) ddao.get(key));
    }

    @RequestMapping(value = "/add/{key}", method = RequestMethod.POST)
    public void addKeyValueUrl(@PathVariable String key, @RequestParam(value = "value") String value) {
        log.info("request hit redis/add/, the supplied key was: " + key
                + " and the supplied value was: " + value);
        Value ddao = ctx.getBean(Value.class);
        ddao.set(key, value);
    }

    @RequestMapping(value = "/addvalue", method = RequestMethod.POST)
    public void addKeyValue(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        log.info("request hit redis/addvalue, the supplied key was: " + key
                + " and the supplied value was: " + value);
        Value ddao = ctx.getBean(Value.class);
        ddao.set(key, value);
    }

    @RequestMapping(value = "/update/{key}", method = RequestMethod.PUT)
    public void setKeyValueUrl(@PathVariable String key, @RequestParam(value = "value") String value) {
        log.info("request hit redis/update/, the supplied key was: " + key
                + " and the supplied value was: " + value);
        Value ddao = ctx.getBean(Value.class);
        ddao.update(key, value);
    }

    @RequestMapping(value = "/updatevalue", method = RequestMethod.PUT)
    public void updateKeyValue(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        log.info("request hit redis/updatevalue, the supplied key was: " + key
                + " and the supplied value was: " + value);
        Value ddao = ctx.getBean(Value.class);
        ddao.update(key, value);
    }

    @RequestMapping(value = "/delete/{key}", method = RequestMethod.DELETE)
    public void deleteKeyValueUrl(@PathVariable String key) {
        log.info("request hit redis/delete/, the supplied key was: " + key);
        Value ddao = ctx.getBean(Value.class);
        ddao.delete(key);
    }

    @RequestMapping(value = "/deletekey", method = RequestMethod.DELETE)
    public void deleteKeyValue(@RequestParam(value = "key") String key) {
        log.info("request hit redis/deletevalue, the supplied key was: " + key);
        Value ddao = ctx.getBean(Value.class);
        ddao.delete(key);
    }
}
