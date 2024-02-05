from odoo import fields, models

class Genero(models.Model):
		# El nombre técnico del modelo, usualmente en formato 'nombre_del_modulo.nombre_del_modelo'
    _name = "modulo00.genero"  
		# Una descripción para el modelo
    _description = 'Genero' 
	# Campo Char para una descripción, 'string' es opcional y define el nombre del campo en la vista 
    name = fields.Char(string='Descripción')