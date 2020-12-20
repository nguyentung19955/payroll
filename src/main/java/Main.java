import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.util.ResourceUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Danh sách nhân viên:");
        List<Employee> employees = getEmployee();
        employees.forEach(System.out::println);
    }

    private static List<Employee> getEmployee() throws IOException {
        File file = ResourceUtils.getFile("classpath:employee.csv");

        CsvMapper mapper = new CsvMapper(); //Dùng để ánh xạ cột trong CSV với từng trường trong POJO
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); // Dòng đầu tiên sử dụng làm Header
        ObjectReader oReader = mapper.readerFor(Employee.class).with(schema); //Cấu hình bộ đọc CSV phù hợp với kiểu Car.class

        Reader reader = new FileReader(file);
        MappingIterator<Employee> mi = oReader.readValues(reader); //Iterator đọc từng dòng trong file
        List<Employee> employees = new ArrayList<>();
        while (mi.hasNext()) {
            Employee employee = mi.next();
            employees.add(employee);
        }
        return employees;
    }
}
