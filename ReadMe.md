## Mô tả sourcecode

### Danh sách các method

1. getEmployee
2. getAge
3. getSenior
4. calculateSalary

### Mô tả các method
**getEmployee**: Đọc file CSV tại thư mục resource và lấy ra thông tin từng nhân viên rồi lưu vào danh sách
  
**getAge**: Tính tuổi nhân viên bằng cách lấy thời điểm hiện tại trừ đi ngày sinh và lấy khoảng cách năm  
> Ví dụ:  
Nhân viên A sinh ngày 20/01/1990 và thời điểm hiện tại là 20/12/2020  
=> Tuổi nhân viên hiện tại là 30  

**getSenior**: Tính thâm niên nhân viên bằng cách lấy thời điểm hiện tại trừ đi ngày bắt đầu làm việc
> Ví dụ:  
Nhân viên A bắt đầu làm việc từ ngày 12/02/2015 và thời điểm hiện tại là 20/12/2020  
=> Thâm niên hiện tại là 5 năm 10 tháng

**calculateSalary**: Tính lương theo thâm niên làm đủ 12 tháng thì tăng lương với hệ số 6% 
> Ví dụ:  
Nhân viên A có lương khởi điểm là 100, thâm niên hiện tại là 3 năm 10 tháng
Năm 1: lương khởi điểm x (1 + 0.06)
Năm 2: lương sau năm 1 x (1 + 0.06)
Năm 3: lương sau năm 2 x (1 + 0.06)
=> Lương hiện tại = lương khởi điểm x (1 + 0.06) ^ năm thâm niên
