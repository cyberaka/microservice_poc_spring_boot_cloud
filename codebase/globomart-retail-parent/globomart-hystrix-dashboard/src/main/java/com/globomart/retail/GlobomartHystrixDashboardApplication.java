/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.globomart.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix dashboard entry point. Refer to turbine documentation on how to find
 * out the location of the stream URL for an API.
 *
 * @author cyberaka
 */
@EnableHystrixDashboard
@SpringBootApplication
public class GlobomartHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobomartHystrixDashboardApplication.class, args);
    }
}
