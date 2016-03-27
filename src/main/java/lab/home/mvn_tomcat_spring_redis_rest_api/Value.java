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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Dimitrios Dimas <dimitrios.work@outlook.com>
 */
@Repository
public class Value {
    
    @Autowired
    private RedisTemplate< String, Object> template;

    public Object get(final String key) {
        return template.opsForValue().get(key);
    }
    
    public Iterator getAll() {
        return template.opsForSet().scan("0", ScanOptions.NONE);
    }

    public void set(final String key, final String value) {
        template.opsForValue().set(key, value);
    }

    public void update(final String key, final String value) {
        template.opsForValue().set(key, value);
    }
    
    public void delete(final String key) {
        template.delete(key);
    }

}
