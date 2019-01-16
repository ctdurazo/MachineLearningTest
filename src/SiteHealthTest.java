import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.Id3;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gowtham Girithar Srirangasamy
 *
 */
public class SiteHealthTest {

	/** file names are defined*/
	public static final String TRAINING_DATA_SET_FILENAME="siteHealth-train.arff";
	public static final String TESTING_DATA_SET_FILENAME="siteHealth-test.arff";
	public static final List<Datapoint> input = new ArrayList<>();

	/**
	 * This method is to load the data set.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Instances getDataSet(String fileName) throws IOException {
		/**
		 * we can set the file i.e., loader.setFile("finename") to load the data
		 */
		int classIdx = 1;
		/** the arffloader to load the arff file */
		ArffLoader loader = new ArffLoader();
		/** load the traing data */
		loader.setSource(SiteHealthTest.class.getResourceAsStream("/" + fileName));
		/**
		 * we can also set the file like loader3.setFile(new
		 * File("test-confused.arff"));
		 */
		//loader.setFile(new File(fileName));
		Instances dataSet = loader.getDataSet();
		/** set the index based on the data given in the arff files */
		dataSet.setClassIndex(classIdx);
		return dataSet;
	}

	/**
	 * This method is to load the data set.
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static Instances getDataSet(List<Datapoint> input) throws IOException {
		int classIdx = 1;

		FastVector fv = new FastVector(2);
		fv.addElement("yes");
		fv.addElement("no");

		FastVector resultfv = new FastVector(3);
		resultfv.addElement("Live");
		resultfv.addElement("Dead");
		resultfv.addElement("Reborn");

		Attribute yearly = new Attribute("yearly", fv);
		Attribute monthly = new Attribute("monthly", fv);
		Attribute weekly = new Attribute("weekly", fv);
		Attribute daily = new Attribute("daily", fv);
		Attribute result = new Attribute("result", resultfv);

		FastVector attrList = new FastVector(5);
		attrList.addElement(yearly);
		attrList.addElement(monthly);
		attrList.addElement(weekly);
		attrList.addElement(daily);
		attrList.addElement(result);
		Instances dataSet = new Instances("decision.symbolic", attrList, 0);

		Instance inst = new Instance(5);

		for (Datapoint datapoint : input) {
			inst.setValue(yearly, datapoint.getYearly());
			inst.setValue(monthly, datapoint.getMonthly());
			inst.setValue(weekly, datapoint.getWeekly());
			inst.setValue(daily, datapoint.getDaily());
			inst.setValue(result, datapoint.getResult());

			dataSet.add(inst);
		}

		dataSet.setClassIndex(classIdx);

		return dataSet;
	}

	/**
	 * This method is used to process the input and return the statistics.
	 *
	 * @throws Exception
	 */
	public static void process() throws Exception {

		input.add(new Datapoint("no", "no", "no", "no", "Live"));
		input.add(new Datapoint("no", "no", "no", "yes", "Live"));
		input.add(new Datapoint("no", "no", "yes", "yes", "Live"));
		input.add(new Datapoint("no", "yes", "yes", "yes", "Dead"));
		input.add(new Datapoint("no", "yes", "yes", "yes", "Dead"));
		input.add(new Datapoint("yes", "yes", "yes", "no", "Dead"));
		input.add(new Datapoint("yes", "yes", "no", "no", "Reborn"));
		input.add(new Datapoint("yes", "no", "no", "no", "Reborn"));

		Instances trainingDataSet = getDataSet(input);
		//Instances trainingDataSet = getDataSet(TRAINING_DATA_SET_FILENAME);
		Instances testingDataSet = getDataSet(TESTING_DATA_SET_FILENAME);

		System.out.println("************************** J48 *************************");
		/** Classifier here is Linear Regression */
		Classifier classifier = new J48();

		//J48,Id3
		/** */
		classifier.buildClassifier(trainingDataSet);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with testing data
		 */
		Evaluation eval = new Evaluation(trainingDataSet);
		eval.evaluateModel(classifier, testingDataSet);
		/** Print the algorithm summary */
		System.out.println("** Decision Tress Evaluation with Datasets **");
		System.out.println(eval.toSummaryString());
		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(classifier);
		System.out.println(eval.toMatrixString());
		System.out.println(eval.toClassDetailsString());

		System.out.println("************************** ID3 *************************");
		/** Classifier here is Linear Regression */
		Classifier id3Classifier = new Id3();

		//J48,Id3
		/** */
		id3Classifier.buildClassifier(trainingDataSet);
		/**
		 * train the alogorithm with the training data and evaluate the
		 * algorithm with testing data
		 */
		Evaluation evalId3 = new Evaluation(trainingDataSet);
		evalId3.evaluateModel(id3Classifier, testingDataSet);
		/** Print the algorithm summary */
		System.out.println("** Decision Tress Evaluation with Datasets **");
		System.out.println(evalId3.toSummaryString());
		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(id3Classifier);
		System.out.println(evalId3.toMatrixString());
		System.out.println(evalId3.toClassDetailsString());
	}

}