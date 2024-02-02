# -*- coding: utf-8 -*-
from odoo import fields, models

class Presupuesto(models.Model):
		# El nombre técnico del modelo, usualmente en formato 'nombre_del_modulo.nombre_del_modelo'
	_name = "modulo00.presupuesto"  
		# Una descripción para el modelo
	_inherit = ['image.mixin']
	_description = 'Presupuesto' 
	# Campo Char para una descripción, 'string' es opcional y define el nombre del campo en la vista    
	name = fields.Char(string='Descripción')  
	fecha_estreno = fields.Date() # Fecha
    # Enumerado fijo
	clasificacion = fields.Selection(selection=[
        ('G', 'Público general'), # Público general
        ('PG', 'Compañía recomendada'), # Se recomienda la compañía de un adulto
        ('PG-13', 'Mayores de 13 años'), # Mayores de 13 
        ('R', 'Compañía obligatoria'), # Compañía de un adulto obligatorio
        ('NC-17', 'Mayores 18'), # Mayores de 18
    ])
	puntuacion = fields.Integer() 
	active = fields.Boolean() # checkbox que dice si visible o no
	director_id = fields.Many2one(
        comodel_name='res.partner' # Se puede encontrar en la url de contactos
    )
	genero_ids = fields.Many2many(
        comodel_name='modulo00.genero' # Se puede encontrar en la url de contactos
    )
	vista_general = fields.Text()
	link_trailer = fields.Char(string = 'Descripción')
	es_libro = fields.Boolean(string='Versión libro')
	libro = fields.Binary(string='Libro')