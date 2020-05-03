package elements.animals;

enum AnimalType {
	CALF, HEIFER, COW, BULL;
	
	public static AnimalType identifyType(String type){
		AnimalType typeToReturn = null;
		for (AnimalType tmpType : AnimalType.values()){
			if(tmpType.toString().equalsIgnoreCase(type)){
				typeToReturn = tmpType;
				break;
			}
		}
		return typeToReturn;
	}
}
