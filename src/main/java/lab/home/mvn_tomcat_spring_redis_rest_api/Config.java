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

import lab.home.mvn_tomcat_spring_redis_rest_api.config.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Dimitrios Dimas <dimitrios.work@outlook.com>
 */
@Configuration
@Import({SpringMVCConfig.class, SpringRedisConfig.class})
@ComponentScan(basePackages = {"lab.home.mvn_tomcat_spring_redis_rest_api"})
class Config {

}
