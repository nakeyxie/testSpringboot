package testConnect;

import java.util.List;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class IgonrefieldPreFilter implements PropertyFilter {
    private final Class<?> clazz;
    private final List<String> excludes;
    private final boolean filterNull;

	public IgonrefieldPreFilter(boolean filterNull,
			List<String> excludeProperties) {
		this(null,filterNull,excludeProperties);
	}

	public IgonrefieldPreFilter(Class<?> clazz, boolean filterNull,
			List<String> excludeProperties) {
		  super();
		  this.clazz=clazz;
		  this.excludes=excludeProperties;
		  this.filterNull=filterNull;
		  
	}
	
	public Class<?> getClazz(){
		return clazz;
	}

	@Override
	public boolean apply(Object source, String name, Object value) {
		boolean isApply=true;
		if(source==null){
			isApply=false;
		}else if(filterNull && value==null){
			isApply=false;
		}else if(clazz!=null && !clazz.isInstance(source)){
			isApply=false;
		}else if(this.excludes!=null && this.excludes.contains(name)){
			isApply=false;
		}else if(value!=null && value.equals(Double.NaN)){}
		return isApply;
	}

}
