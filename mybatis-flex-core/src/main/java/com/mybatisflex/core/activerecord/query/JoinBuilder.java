/*
 *  Copyright (c) 2022-2023, Mybatis-Flex (fuhai999@gmail.com).
 *  <p>
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  <p>
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.mybatisflex.core.activerecord.query;

import com.mybatisflex.core.query.CPI;
import com.mybatisflex.core.query.Join;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.RawFragment;

/**
 * Lambda joins 构建器。
 *
 * @author 王帅
 * @since 2023-07-28
 */
public class JoinBuilder<R extends QueryModel<R>> {

    private final R queryModel;
    private final Join join;

    public JoinBuilder(R queryModel, Join join) {
        this.queryModel = queryModel;
        this.join = join;
    }

    public JoinBuilder<R> as(String alias) {
        CPI.getJoinQueryTable(join).as(alias);
        return this;
    }

    public R on(String on) {
        join.on(new RawFragment(on));
        return queryModel;
    }

    public R on(QueryCondition on) {
        join.on(on);
        return queryModel;
    }

}
