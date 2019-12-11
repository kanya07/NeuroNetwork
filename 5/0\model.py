import keras
from keras.layers.core import Dense
from keras.layers.core import Dropout
from keras.layers import Input
from keras.models import Model
from keras.regularizers import *


def get_model():
	aliases = {}
	Input_1 = Input(shape=(7,), name='Input_1')
	Dense_1 = Dense(name='Dense_1',output_dim= 100,activation= 'relu' )(Input_1)
	Dropout_1 = Dropout(name='Dropout_1',p= 0.2)(Dense_1)
	Dense_2 = Dense(name='Dense_2',output_dim= 2,activation= 'softmax' )(Dropout_1)

	model = Model([Input_1],[Dense_2])
	return aliases, model


from keras.optimizers import *

def get_optimizer():
	return Adadelta()

def is_custom_loss_function():
	return False

def get_loss_function():
	return 'categorical_crossentropy'

def get_batch_size():
	return 32

def get_num_epoch():
	return 20

def get_data_config():
	return '{"datasetLoadOption": "batch", "kfold": 1, "shuffle": false, "mapping": {"sex": {"port": "InputPort0", "options": {}, "type": "Categorical", "shape": ""}, "survived": {"port": "OutputPort0", "options": {}, "type": "Categorical", "shape": ""}, "age": {"port": "InputPort0", "options": {}, "type": "Categorical", "shape": ""}, "class": {"port": "InputPort0", "options": {}, "type": "Categorical", "shape": ""}}, "numPorts": 1, "dataset": {"name": "titanic", "type": "public", "samples": 1316}, "samples": {"validation": 131, "training": 1052, "split": 3, "test": 131}}'