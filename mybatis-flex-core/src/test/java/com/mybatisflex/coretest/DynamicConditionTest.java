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

package com.mybatisflex.coretest;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.CollectionUtil;
import com.mybatisflex.core.util.StringUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.mybatisflex.coretest.table.AccountTableDef.ACCOUNT;

/**
 * 动态条件测试。
 *
 * @author 王帅
 * @since 2023-08-10
 */
public class DynamicConditionTest {

    @Test
    public void test01() {
        String sql = QueryWrapper.create()
            .from(ACCOUNT)
            .where(ACCOUNT.AGE.ge(18))
            .or(qw -> qw.where(ACCOUNT.ID.eq(1)), false)
            .toSQL();

        System.out.println(sql);
    }

    @Test
    public void test02() {
        List<Integer> idList = Arrays.asList(1, 2, 3);

        String sql = QueryWrapper.create()
            .from(ACCOUNT)
            .where(ACCOUNT.ID.in(idList).when(false))
            .where(ACCOUNT.ID.in(idList, CollectionUtil::isNotEmpty))
            .where(ACCOUNT.ID.in(idList).when(idList::isEmpty))
            .toSQL();

        System.out.println(sql);
    }

    @Test
    public void test03() {
        String sql = QueryWrapper.create()
            .from(ACCOUNT)
            .where(ACCOUNT.ID.eq("1", StringUtil::isNumeric))
            .toSQL();

        System.out.println(sql);
    }

    @Test
    public void test04() {
        String sql = QueryWrapper.create()
            .from(ACCOUNT)
            .where(ACCOUNT.ID.between('1', '2', (start, end) -> start < end))
            .toSQL();

        System.out.println(sql);
    }

}
