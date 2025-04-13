package com.cv.s0402notifyservicepojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 5183383994517395243L;

    private List<List<String>> table;

    public void addHeader(String csv) {
        List<String> header = parseCsv(csv);
        if (table == null) {
            table = new ArrayList<>();
        }
        if (!table.isEmpty()) {
            throw new IllegalStateException("Header already exists");
        }
        table.add(header);
    }

    public void addRow(String csv) {
        List<String> row = parseCsv(csv);
        if (table == null || table.isEmpty()) {
            throw new IllegalStateException("Add header first");
        }
        if (row.size() != table.get(0).size()) {
            throw new IllegalArgumentException("Row size does not match header");
        }
        table.add(row);
    }

    public void removeRow(int index) {
        if (table == null || index <= 0 || index >= table.size()) {
            throw new IndexOutOfBoundsException("Cannot remove header or out-of-bounds row");
        }
        table.remove(index);
    }

    public List<String> getHeader() {
        if (table == null || table.isEmpty()) return Collections.emptyList();
        return table.get(0);
    }

    public List<List<String>> getRows() {
        if (table == null || table.size() <= 1) return Collections.emptyList();
        return table.subList(1, table.size());
    }

    private List<String> parseCsv(String csv) {
        return new ArrayList<>(Arrays.asList(csv.split("\\s*,\\s*")));
    }
}
