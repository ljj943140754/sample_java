package com.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


 //mybatis plus 实体类逆向工程
public class AutoMappingUtil {
	@Test
	   public void AutoCreate(){
		String path="D://java_base/sample";
	      AutoGenerator mpg = new AutoGenerator();
	      //MyBatis-Plus 全局策略配置
	      GlobalConfig gc = new GlobalConfig();
	      //生成文件的输出目录【默认 D 盘根目录】
	      gc.setOutputDir(path+"/src/main/java");
	      //gc.setOutputDir("D:\\Auto");
	      //是否覆盖已有文件
	      gc.setFileOverride(false);
	      //开启 ActiveRecord 模式
	      gc.setActiveRecord(true);
	      //是否在xml中添加二级缓存配置
	      gc.setEnableCache(true);
	      //开启 BaseResultMap
	      gc.setBaseResultMap(true);
	      //开启 baseColumnList
	      gc.setBaseColumnList(true);
	      // 开发人员
	      gc.setAuthor("予之文化传媒");
	      // 自定义文件命名，注意 %s 会自动填充表实体属性！
	      gc.setMapperName("%sMapper");
	      gc.setXmlName("%sMapper");
	      gc.setServiceName("%sService");
	      gc.setServiceImplName("%sServiceImpl");
	      gc.setControllerName("%sController");
	      mpg.setGlobalConfig(gc);
	      // 数据源配置
	      DataSourceConfig dsc = new DataSourceConfig();
	      dsc.setDbType(DbType.MYSQL);
	      dsc.setDriverName("com.mysql.jdbc.Driver");
	      dsc.setUrl("jdbc:mysql://localhost:3306/sample?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
	      dsc.setUsername("root");
	      dsc.setPassword("root");
	      dsc.setTypeConvert(new MySqlTypeConvert() {//修改mysql datetime 生成实体类 date 类型
	    	  @Override
              public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
	    		  if ( fieldType.toLowerCase().contains( "datetime" ) ) {
                      return DbColumnType.DATE;
                  }
	    		  return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
	    	  }
	      });
	      mpg.setDataSource(dsc);
	      // 策略配置
	      StrategyConfig strategy = new StrategyConfig();
	      strategy.setTablePrefix(new String[] { "t_m_", "t_p_", "t_s_", "t_r_", "t_c_"});// 此处可以修改为表的前缀
	      strategy.setNaming(NamingStrategy.no_change);// 表名生成策略
	      strategy.setInclude(new String[] {"album","classify","photo","qr_code","worker"}); // 需要生成的表
	      //strategy.setExclude(new String[]{"test"}); // 排除生成的表
	      // 公共父类
	     // strategy.setSuperControllerClass("com.common.bean.pageObject");
	      strategy.setSuperEntityClass("com.common.bean.pageObject");
	      mpg.setStrategy(strategy);
	      // 包配置
	      PackageConfig pc = new PackageConfig();
	      pc.setParent("com.sample");
//	      pc.setModuleName("member");
	      mpg.setPackageInfo(pc);
	      // 执行生成
	      mpg.execute();
	   }
}
