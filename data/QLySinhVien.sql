
CREATE TABLE LopHoc(
	maLop varchar(20) NOT NULL primary key,
	tenLop nvarchar(100) NOT NULL)

CREATE TABLE SinhVien(
	masv char(10) NOT NULL primary key,
	ho nvarchar(30) NULL,
	ten nvarchar(30) NOT NULL,
	phai nvarchar(10) NULL,
	email varchar(50) NULL,
	diaChi nvarchar(100) NULL,
	maLop varchar(20) NULL references LopHoc(maLop))

-- Chèn dữ liệu vào bảng LopHoc
INSERT INTO LopHoc (maLop, tenLop) VALUES ('LP001', N'Kỹ thuật phần mềm'), ('LP002', N'Khoa học máy tính'), ('LP003', N'Khoa học dữ liệu')

-- Chèn dữ liệu vào bảng SinhVien
INSERT INTO SinhVien (masv, ho, ten, phai, email, diaChi, maLop) 
VALUES ('SV001', N'Nguyễn', N'Văn A', N'Nam', 'nguyenvana@example.com', N'Hà Nội', 'LP001'),
		('SV002', N'Trần', N'Thị B', N'Nữ', 'tranthib@example.com', N'Hồ Chí Minh', 'LP002'),
		('SV003', N'Lê', N'Trung C', N'Nam', 'letrungc@example.com', N'Đà Nẵng', 'LP001')
