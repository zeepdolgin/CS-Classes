


public int findStudent(Node2 LocalRoot, String nameToFind) {
	if (LocalRoot != null){
		String name = LocalRoot.stident_name;
		if (name.equals(nameToFind)){
			return LocalRoot.grade;
		}else{
			findStudent(LocalRoot.leftChild, String nameToFind);
			findStudent(LocalRoot,rightChild, String nameToFind);
		}
	}
}