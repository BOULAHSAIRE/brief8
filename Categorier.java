package Model;

public class Categorier {

		private int IdCategory;
		private String CategoryName;
		public Categorier(int idCategory, String categoryName) {
			super();
			IdCategory = idCategory;
			CategoryName = categoryName;
		}
		public int getIdCategory() {
			return IdCategory;
		}
		public void setIdCategory(int idCategory) {
			IdCategory = idCategory;
		}
		public String getCategoryName() {
			return CategoryName;
		}
		public void setCategoryName(String categoryName) {
			CategoryName = categoryName;
		}
		@Override
		public String toString() {
			return "Categorier [IdCategory=" + IdCategory + ", CategoryName=" + CategoryName + "]";
		}
	
		
}