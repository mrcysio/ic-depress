/*
ImpressiveCode Depress Framework
Copyright (C) 2013  ImpressiveCode contributors

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.impressivecode.depress.metric.noi;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.knime.core.data.DataRow;
import org.knime.core.data.DataTableSpec;
import org.knime.core.data.collection.ListCell;
import org.knime.core.data.def.IntCell;

import com.google.common.collect.Lists;

/**
 * 
 * @author Marek Majchrzak, ImpressiveCode
 * 
 */
public class NumberOfIssuesMetricTableFactoryTest {

    @Test
    public void shouldCreateDataColumnSpec() {
        DataTableSpec spec = NumberOfIssuesMetricTableFactory.createDataColumnSpec();
        assertThat(spec.getNumColumns()).isEqualTo(3);
    }

    @Test
    public void shouldCreateTableRow() {
        //given
        NoIMetricType noi = new NoIMetricType();
        noi.setClassName("ClassA");
        noi.setIssues(Lists.newArrayList("i1", "i2", "i2"));
        //when
        DataRow row = NumberOfIssuesMetricTableFactory.createTableRow(noi);
        //then
        assertThat(row.getKey().getString()).isEqualTo("ClassA");
        assertThat(((ListCell)row.getCell(0)).get(0).toString()).isEqualTo("i1");
        assertThat(((ListCell)row.getCell(0)).get(1).toString()).isEqualTo("i2");
        assertThat(((ListCell)row.getCell(0)).get(2).toString()).isEqualTo("i2");
        assertThat(((IntCell)row.getCell(1)).getIntValue()).isEqualTo(3);
        assertThat(((IntCell)row.getCell(2)).getIntValue()).isEqualTo(2);
    }

}
