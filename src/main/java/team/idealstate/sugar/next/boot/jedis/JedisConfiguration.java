/*
 *    Copyright 2025 ideal-state
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package team.idealstate.sugar.next.boot.jedis;

import java.util.Map;
import lombok.Data;
import team.idealstate.sugar.validate.annotation.NotNull;
import team.idealstate.sugar.next.context.annotation.component.Configuration;

@Configuration(uri = "/database/Jedis.yml", release = "bundled:/database/Jedis.yml")
@Data
public class JedisConfiguration {

    @NotNull
    private String host;

    @NotNull
    private Integer port;

    @NotNull
    private Integer database;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private Integer timeout;

    @NotNull
    private Boolean ssl;

    @NotNull
    private Map<String, Object> properties;
}
