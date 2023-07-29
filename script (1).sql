USE [master]
GO
/****** Object:  Database [BMOS_v4]    Script Date: 7/28/2023 12:30:24 PM ******/
CREATE DATABASE [BMOS_v6]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BMOS_v4', FILENAME = N'E:\MCS_SQL\MSSQL16.MSSQLSERVER\MSSQL\DATA\BMOS_v4.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BMOS_v4_log', FILENAME = N'E:\MCS_SQL\MSSQL16.MSSQLSERVER\MSSQL\DATA\BMOS_v4_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BMOS_v4] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BMOS_v4].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BMOS_v4] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BMOS_v4] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BMOS_v4] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BMOS_v4] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BMOS_v4] SET ARITHABORT OFF 
GO
ALTER DATABASE [BMOS_v4] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BMOS_v4] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BMOS_v4] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BMOS_v4] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BMOS_v4] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BMOS_v4] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BMOS_v4] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BMOS_v4] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BMOS_v4] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BMOS_v4] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BMOS_v4] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BMOS_v4] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BMOS_v4] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BMOS_v4] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BMOS_v4] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BMOS_v4] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BMOS_v4] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BMOS_v4] SET RECOVERY FULL 
GO
ALTER DATABASE [BMOS_v4] SET  MULTI_USER 
GO
ALTER DATABASE [BMOS_v4] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BMOS_v4] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BMOS_v4] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BMOS_v4] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BMOS_v4] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BMOS_v4] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BMOS_v4', N'ON'
GO
ALTER DATABASE [BMOS_v4] SET QUERY_STORE = ON
GO
ALTER DATABASE [BMOS_v4] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BMOS_v4]
GO
/****** Object:  Table [dbo].[tbl_Bird]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Bird](
	[bird_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[bird_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Blog]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Blog](
	[blog_id] [int] IDENTITY(1,1) NOT NULL,
	[thumbnail] [nvarchar](max) NULL,
	[title] [nvarchar](100) NULL,
	[date_update] [date] NULL,
	[content] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[status] [bit] NULL,
	[hashtag] [nvarchar](100) NULL,
	[bird_id] [int] NULL,
 CONSTRAINT [PK__tbl_Blog__2975AA2840840A0A] PRIMARY KEY CLUSTERED 
(
	[blog_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Category]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Category](
	[category_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NULL,
	[status] [bit] NULL,
	[img] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Feedback]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Feedback](
	[feedback_id] [int] IDENTITY(1,1) NOT NULL,
	[note] [nvarchar](max) NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[feedback_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_LifeCycle]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_LifeCycle](
	[lifecycle_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[lifecycle_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Meal]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Meal](
	[quantity] [int] NULL,
	[meal_package_id] [int] NULL,
	[product_id] [int] NULL,
	[description] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_MealPackage]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_MealPackage](
	[meal_package_id] [int] IDENTITY(1,1) NOT NULL,
	[meal_code] [nvarchar](6) NULL,
	[title_mealpackage] [nvarchar](350) NULL,
	[quantity] [int] NULL,
	[price] [int] NULL,
	[discount_price] [int] NULL,
	[thumbnail] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[recipe] [nvarchar](max) NULL,
	[create_at] [date] NULL,
	[update_at] [date] NULL,
	[status] [bit] NULL,
	[bird_id] [int] NULL,
	[lifecycle_id] [int] NULL,
	[img] [nvarchar](max) NULL,
 CONSTRAINT [PK__tbl_Meal__D4B0B2EE41384D97] PRIMARY KEY CLUSTERED 
(
	[meal_package_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_MealPlan]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_MealPlan](
	[meal_package_id] [int] NULL,
	[breakfast] [nvarchar](max) NULL,
	[lunch] [nvarchar](max) NULL,
	[dinner] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Order]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Order](
	[order_id] [int] IDENTITY(1,1) NOT NULL,
	[order_code] [nvarchar](10) NULL,
	[order_date] [date] NULL,
	[note] [nvarchar](max) NULL,
	[totalMoney] [int] NULL,
	[status] [bit] NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_OrderDetail]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_OrderDetail](
	[orderDetail_id] [int] IDENTITY(1,1) NOT NULL,
	[price] [int] NULL,
	[quantity] [int] NULL,
	[product_id] [int] NULL,
	[oder_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderDetail_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Product]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Product](
	[product_id] [int] IDENTITY(1,1) NOT NULL,
	[product_code] [nvarchar](6) NULL,
	[title] [nvarchar](350) NULL,
	[quantity] [int] NULL,
	[price] [int] NULL,
	[discount_price] [int] NULL,
	[weight] [float] NULL,
	[thumbnail] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[create_at] [date] NULL,
	[update_at] [date] NULL,
	[status] [bit] NULL,
	[category_id] [int] NULL,
	[feedback_id] [int] NULL,
	[bird_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Role]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 7/28/2023 12:30:24 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_User](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[fullname] [nvarchar](20) NULL,
	[email] [nvarchar](100) NULL,
	[phone_number] [nvarchar](20) NULL,
	[address] [nvarchar](200) NULL,
	[status] [bit] NULL,
	[role_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tbl_Blog]  WITH CHECK ADD  CONSTRAINT [FK__tbl_Blog__bird_i__5629CD9C] FOREIGN KEY([bird_id])
REFERENCES [dbo].[tbl_Bird] ([bird_id])
GO
ALTER TABLE [dbo].[tbl_Blog] CHECK CONSTRAINT [FK__tbl_Blog__bird_i__5629CD9C]
GO
ALTER TABLE [dbo].[tbl_Feedback]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[tbl_User] ([user_id])
GO
ALTER TABLE [dbo].[tbl_Meal]  WITH CHECK ADD  CONSTRAINT [FK__tbl_Meal__meal_p__4BAC3F29] FOREIGN KEY([meal_package_id])
REFERENCES [dbo].[tbl_MealPackage] ([meal_package_id])
GO
ALTER TABLE [dbo].[tbl_Meal] CHECK CONSTRAINT [FK__tbl_Meal__meal_p__4BAC3F29]
GO
ALTER TABLE [dbo].[tbl_Meal]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[tbl_Product] ([product_id])
GO
ALTER TABLE [dbo].[tbl_MealPackage]  WITH CHECK ADD  CONSTRAINT [FK__tbl_MealP__bird___48CFD27E] FOREIGN KEY([bird_id])
REFERENCES [dbo].[tbl_Bird] ([bird_id])
GO
ALTER TABLE [dbo].[tbl_MealPackage] CHECK CONSTRAINT [FK__tbl_MealP__bird___48CFD27E]
GO
ALTER TABLE [dbo].[tbl_MealPackage]  WITH CHECK ADD  CONSTRAINT [FK__tbl_MealP__lifec__49C3F6B7] FOREIGN KEY([lifecycle_id])
REFERENCES [dbo].[tbl_LifeCycle] ([lifecycle_id])
GO
ALTER TABLE [dbo].[tbl_MealPackage] CHECK CONSTRAINT [FK__tbl_MealP__lifec__49C3F6B7]
GO
ALTER TABLE [dbo].[tbl_MealPlan]  WITH CHECK ADD  CONSTRAINT [FK__tbl_MealP__meal___5812160E] FOREIGN KEY([meal_package_id])
REFERENCES [dbo].[tbl_MealPackage] ([meal_package_id])
GO
ALTER TABLE [dbo].[tbl_MealPlan] CHECK CONSTRAINT [FK__tbl_MealP__meal___5812160E]
GO
ALTER TABLE [dbo].[tbl_Order]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[tbl_User] ([user_id])
GO
ALTER TABLE [dbo].[tbl_OrderDetail]  WITH CHECK ADD FOREIGN KEY([oder_id])
REFERENCES [dbo].[tbl_Order] ([order_id])
GO
ALTER TABLE [dbo].[tbl_OrderDetail]  WITH CHECK ADD FOREIGN KEY([product_id])
REFERENCES [dbo].[tbl_Product] ([product_id])
GO
ALTER TABLE [dbo].[tbl_Product]  WITH CHECK ADD FOREIGN KEY([category_id])
REFERENCES [dbo].[tbl_Category] ([category_id])
GO
ALTER TABLE [dbo].[tbl_Product]  WITH CHECK ADD FOREIGN KEY([feedback_id])
REFERENCES [dbo].[tbl_Feedback] ([feedback_id])
GO
ALTER TABLE [dbo].[tbl_User]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[tbl_Role] ([role_id])
GO
USE [master]
GO
ALTER DATABASE [BMOS_v4] SET  READ_WRITE 
GO
